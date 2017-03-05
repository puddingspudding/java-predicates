# Java8 Predicates

The intention of this project is to improve readability of equality and relational operators (< > <= >= == !=) using predefined [Predicates](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html).
It also contains a Predicate interface with then(), orElse() and elseIf() to replace if-then and if-then-else statements.

----------
## mvn
```xml
<dependency>
    <groupId>com.github.puddingspudding</groupId>
    <artifactId>predicates</artifactId>
    <version>0.4</version>
</dependency>
```
----------

## Predicates
- **isEqualTo** { a == b }
- **isNotEqualTo** { a != b }
- **isBiggerThan** { a > b }
- **isSmallerThan** { a < b }
- **isEqualOrBiggerThan** { a >= b }
- **isEqualOrSmallerThan** { a <= b }
- **isInRange** { a <= x && x <= b }
- **isNotInRage** { x < a && b < x }
- **isNegative** { a < 0 }
- **isPositive** { a > 0 }
- **isEven** { x % 2 == 0 }
- **isOdd** { x % 2 != 0 }

## Examples
### java.util.function.Predicate
```java
import java.util.function.Predicate;
import static com.github.puddingspudding.IntegerPredicates.*;
import static com.github.puddingspudding.LongPredicates.*;

// isEqualTo
Predicate<Integer> isEqualToOne = isEqualTo(1);
if (isEqualToOne.test(1)) {
    // do something
}

// isNotEqualTo
Predicate<Integer> isNotEqualToOne = isNotEqualTo(1);
if (isNotEqualToOne.test(2)) {
    // do something
}

// ...

if (isBiggerThan(10).or(isSmallerThan(-10)).test(x))) {
    // x is awesome
    // or use isNotInRange(-10).apply(10).test(x)
}

Stream.of(1,2,3,4,5,6)
	.filter(isBiggerThan(3))
	.collect(Collectors.toList());
	// [4, 5, 6]

```

## License
[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)
