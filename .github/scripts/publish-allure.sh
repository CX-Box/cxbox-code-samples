#!/usr/bin/env bash
# Publishes allure reports to the gh-pages branch of CX-Box/cxbox-code-samples-allure (GitHub Pages).
#
# Usage: publish-allure.sh <source dir>:<target dir in gh-pages> [<source dir>:<target dir> ...]
#   Every subdirectory of a source dir replaces the subdirectory of the same name in its target dir AS A WHOLE.
#   peaceiris/actions-gh-pages with keep_files: true copied a new report over the old one and never removed the files of
#   the earlier runs: data/ of main/java-21 grew to 930 MB, the site to more than 1 GB, and the deployment of GitHub Pages
#   failed ("Uploaded artifact size ... exceeds the allowed size of 1 GB"), so the new reports were never shown.
#
# Environment:
#   ALLURE_TOKEN  token with push access to CX-Box/cxbox-code-samples-allure
#   RUN           name of the directory of this run inside a report dir (<run id>-<attempt>): a subdirectory that has it
#                 gets an index.html redirecting to it, so the old link <...>/java-NN/ leads to the latest run once the new
#                 version of the site is deployed
#   KEEP_PRS      optional, space separated numbers of the pull requests whose reports are kept; the reports of the other
#                 pull requests (pull_request/<number>) are removed. Not set: nothing is removed.
#
# The clone is shallow and without blobs (the branch is several GB): only the trees are read, the index is changed
# with git rm --cached / git add, and only the new files are sent. A push that lost the race with another job is redone
# from a fresh clone.
set -euo pipefail

: "${ALLURE_TOKEN:?ALLURE_TOKEN is not set}"
: "${RUN:?RUN is not set}"
REPO_URL=${ALLURE_REPO_URL:-"https://x-access-token:${ALLURE_TOKEN}@github.com/CX-Box/cxbox-code-samples-allure.git"}
WORK=$(mktemp -d)

PAIRS=()
for pair in "$@"; do
  src=${pair%%:*}
  target=${pair#*:}
  [ -d "$src" ] || { echo "skip $src: no such directory"; continue; }
  PAIRS+=("$(realpath "$src"):$target")
done
[ ${#PAIRS[@]} -gt 0 ] || { echo "nothing to publish"; exit 0; }

publish() {
  rm -rf "$WORK/site"
  git clone --quiet --depth 1 --filter=blob:none --no-checkout --branch gh-pages "$REPO_URL" "$WORK/site"
  cd "$WORK/site"
  # the index of the last commit, without the files in the work tree
  git read-tree HEAD

  # Reports of the old layout (data/ right in java-NN) hold the files of every earlier run and make the site too big.
  # They are removed once; the next run of that pull request or of main publishes its report in the new layout.
  # This goes before the new reports are added: the report of this run may replace a dir of the old layout.
  for legacy in $(git ls-tree -d -r --name-only HEAD -- main pull_request | grep -E '^(main|pull_request/[0-9]+)/java-[0-9]+/data$' || true); do
    dir=${legacy%/data}
    git rm -r -q --cached --ignore-unmatch -- "$dir"
    echo "removed the report of the old layout $dir"
  done

  if [ -n "${KEEP_PRS+x}" ]; then
    for dir in $(git ls-tree -d --name-only HEAD pull_request/ | grep -E '^pull_request/[0-9]+$' || true); do
      number=${dir#pull_request/}
      if ! printf ' %s ' $KEEP_PRS | grep -q " $number "; then
        git rm -r -q --cached --ignore-unmatch -- "$dir"
        echo "removed the report of the closed pull request $number"
      fi
    done
  fi

  for pair in "${PAIRS[@]}"; do
    src=${pair%%:*}
    target=${pair#*:}
    for dir in "$src"/*/; do
      [ -d "$dir" ] || continue
      name=$(basename "$dir")
      git rm -r -q --cached --ignore-unmatch -- "$target/$name"
      mkdir -p "$target/$name"
      cp -r "$dir". "$target/$name/"
      if [ -d "$target/$name/$RUN" ]; then
        printf '<!DOCTYPE html><meta charset="utf-8"><meta http-equiv="refresh" content="0; url=%s/"><a href="%s/">%s</a>\n' \
          "$RUN" "$RUN" "$RUN" > "$target/$name/index.html"
      fi
      git add -f -- "$target/$name"
      echo "published $target/$name"
    done
  done

  git -c user.name='github-actions[bot]' -c user.email='41898282+github-actions[bot]@users.noreply.github.com' \
    commit -q -m "deploy: ${GITHUB_REPOSITORY:-local}@${GITHUB_SHA:-local} run ${RUN}"
  git push --quiet origin HEAD:gh-pages
}

for attempt in 1 2 3 4 5; do
  if (publish); then
    echo "pushed to gh-pages"
    exit 0
  fi
  echo "::warning::push to gh-pages failed (attempt $attempt), retrying from a fresh clone"
  sleep $((attempt * 15))
done
echo "::error::could not push the report to gh-pages"
exit 1
