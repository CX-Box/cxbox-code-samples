package core.config.selenide;

import static core.config.junit.LogPerTestConfig.log_api_login_only;
import static core.config.junit.LogPerTestConfig.log_api_no_login;

import com.browserup.bup.filters.ResponseFilter;
import com.browserup.bup.util.HttpMessageContents;
import com.browserup.bup.util.HttpMessageInfo;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import com.codeborne.selenide.proxy.SelenideProxyServerFactory;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Proxy;

public class ProxyServerConfig implements SelenideProxyServerFactory {

  @NotNull
  @Override
  public SelenideProxyServer create(Config config, @Nullable Proxy userProvidedProxy) {
    SelenideProxyServer selenideProxyServer = new SelenideProxyServer(config, userProvidedProxy);
    selenideProxyServer.addResponseFilter("ProxyLogResponseFilter", new ProxyLogResponseFilter());
    selenideProxyServer.start();
    return selenideProxyServer;
  }


  @Slf4j
  //TODO>>add java doc
  public static class ProxyLogResponseFilter implements ResponseFilter {

    @NonNull
    private static String toString(
        @NonNull HttpRequest rq,
        @javax.annotation.Nullable HttpMessageContents rqContents,
        @NonNull HttpResponse rs,
        @NonNull HttpMessageContents rsContents) {
      return "\n" + rq.method().name() +
          "\n" + rq.uri() +
          "\n" + "Request: " + /*(rqContents != null ? rqContents.getTextContents() : null) +*/ //TODO>>add request
          "\n" + rs.status() +
          "\n" + "Response: " + rsContents.getTextContents() +
          "\n\n";
    }

    @Override
    public void filterResponse(HttpResponse rs, HttpMessageContents rsContents, HttpMessageInfo rsMessageInfo) {
      var rq = rsMessageInfo.getOriginalRequest();
      HttpMessageContents rqContents = null;
      if (rq instanceof FullHttpMessage httpContent) {
        rqContents = new HttpMessageContents(httpContent);
      }
      if (rq.uri().contains("api/v1/login")) {
        log_api_login_only.trace(toString(rq, rqContents, rs, rsContents));
      } else if (rq.uri().contains("api/v1/")) {
        log_api_no_login.trace(toString(rq, rqContents, rs, rsContents));
      }
    }

  }

}
