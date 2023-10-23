import { useEffect, useState } from 'react'

/**
 * Allows to ignore frequently changing values by returning only the last one received until specified delay.
 *
 * @param value Frequently changing value
 * @param delay Delay until the next change
 * @category Hooks
 */
export function useDebounce<T>(value: T, delay: number) {
    const [debouncedValue, setDebouncedValue] = useState(value)

    useEffect(() => {
        const handler = setTimeout(() => {
            setDebouncedValue(value)
        }, delay)

        return () => {
            clearTimeout(handler)
        }
    }, [value, delay])

    return debouncedValue
}
