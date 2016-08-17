/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.puddingspudding;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Generic Integer predicates.
 */
public final class IntegerPredicates {

    public static Predicate<Integer> isEqualTo(final int i1) {
        return i2 -> i1 == i2;
    }

    public static Predicate<Integer> isNotEqualTo(final int i1) {
        return isEqualTo(i1).negate();
    }

    public static Predicate<Integer> isBiggerThan(final int i1) {
        return i2 -> i1 < i2;
    }

    public static Predicate<Integer> isSmallerThan(final int i1) {
        return i2 -> i1 > i2;
    }

    public static Predicate<Integer> isEqualOrBiggerThan(final int i1) {
        return isSmallerThan(i1).negate();
    }

    public static Predicate<Integer> isEqualOrSmallerThan(final int i1) {
        return isBiggerThan(i1).negate();
    }

    public static Function<Integer, Predicate<Integer>> isInRange(final int min) {
        return max -> isEqualOrBiggerThan(min).and(isEqualOrSmallerThan(max));
    }

    public static Predicate<Integer> isInRange(final int min, final int max) {
        return isEqualOrSmallerThan(max).and(isEqualOrBiggerThan(min));
    }

    public static Predicate<Integer> isNotInRange(final int min, final int max) {
        return isInRange(min, max).negate();
    }

    public static Function<Integer, Predicate<Integer>> isNotInRange(final int min) {
        return max -> isInRange(min).apply(max).negate();
    }

    public static final Predicate<Integer> isNegative() {
        return isSmallerThan(0);
    }

    public static final Predicate<Integer> isPositive() {
        return isBiggerThan(0);
    }

    public static final Predicate<Integer> isEven() {
        return i -> i % 2 == 0;
    }

    public static final Predicate<Integer> isOdd() {
        return isEven().negate();
    }
}
