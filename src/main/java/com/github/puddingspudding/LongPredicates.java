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
 * Generic Long predicates.
 */
public final class LongPredicates {

    public static Predicate<Long> isEqualTo(final Long i1) {
        return i2 -> i1 == i2;
    }

    public static Predicate<Long> isNotEqualTo(final Long i1) {
        return isEqualTo(i1).negate();
    }

    public static Predicate<Long> isBiggerThan(final Long i1) {
        return i2 -> i1 < i2;
    }

    public static Predicate<Long> isSmallerThan(final Long i1) {
        return i2 -> i1 > i2;
    }

    public static Predicate<Long> isEqualOrBiggerThan(final Long i1) {
        return isSmallerThan(i1).negate();
    }

    public static Predicate<Long> isEqualOrSmallerThan(final Long i1) {
        return isBiggerThan(i1).negate();
    }

    public static Function<Long, Predicate<Long>> isInRange(final Long min) {
        return max -> isEqualOrBiggerThan(min).and(isEqualOrSmallerThan(max));
    }

    public static Predicate<Long> isInRange(final Long min, final Long max) {
        return isEqualOrSmallerThan(max).and(isEqualOrBiggerThan(min));
    }

    public static Predicate<Long> isNotInRange(final Long min, final Long max) {
        return isInRange(min, max).negate();
    }

    public static Function<Long, Predicate<Long>> isNotInRange(final Long min) {
        return max -> isInRange(min).apply(max).negate();
    }

    public static final Predicate<Long> isNegative() {
        return isSmallerThan(0L);
    }

    public static final Predicate<Long> isPositive() {
        return isBiggerThan(0L);
    }

    public static final Predicate<Long> isEven() {
        return i -> i % 2 == 0;
    }

    public static final Predicate<Long> isOdd() {
        return isEven().negate();
    }

    private LongPredicates() { }

}
