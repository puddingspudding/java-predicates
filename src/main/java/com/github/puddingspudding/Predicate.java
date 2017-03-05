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
 */
package com.github.puddingspudding;

import java.util.Objects;

/**
 * Predicate extended with then(), orElse() and elseIf().
 */
@FunctionalInterface
@Deprecated
public interface Predicate<T> extends java.util.function.Predicate<T> {

    default Predicate<T> then(Runnable r) {
        return t -> {
            if (this.test(t)) {
                r.run();
                return true;
            }
            return false;
        };
    }

    default Predicate<T> elseIf(java.util.function.Predicate<T> p) {
        return t -> {
            if (!this.test(t)) {
                if (p.test(t)) {
                    return true;
                }
            }
            return false;
        };
    }

    default Predicate<T> orElse(Runnable r) {
        return t -> {
            if (!this.test(t)) {
                r.run();
                return false;
            }
            return true;
        };
    }

    @Override
    default Predicate<T> and(java.util.function.Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    @Override
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    @Override
    default Predicate<T> or(java.util.function.Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

}
