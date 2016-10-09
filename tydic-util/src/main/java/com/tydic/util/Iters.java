package com.tydic.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Iters {

    public static <I> Iterable<I> nullToEmpty(Iterable<I> iter) {
        if (iter == null) {
            return new Iterable<I>() {
                @Override
                public Iterator<I> iterator() {
                    return Collections.emptyIterator();
                }
            };
        }
        return iter;
    }

    public static <I> List<I> nullToEmpty(List<I> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public static <K, V> Map<K, V> nullToEmpty(Map<K, V> map) {
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }

    public static <I> Iterable<I> emptyToNull(Iterable<I> iter) {
        return iter != null && iter.iterator().hasNext() ? iter : null;
    }

    public static <T> List<T> emptyToNull(List<T> list) {
        return list != null && !list.isEmpty() ? list : null;
    }

    public static <T> T[] emptyToNull(T[] array) {
        return array != null && array.length > 0 ? array : null;
    }

    public static long[] emptyToNull(long[] array) {
        return array != null && array.length > 0 ? array : null;
    }
}