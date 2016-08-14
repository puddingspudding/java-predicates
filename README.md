# Java8 Predicates

The intention of this project is to improve readability of equality and relational operators (< > <= >= == !=) using predefined [Predicates](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html).

----------

## Predicates
- **isEqualTo** | a == b
- **isNotEqualTo** | a != b
- **isBiggerThan **| a > b
- **isSmallerThan** | a < b
- **isEqualOrBiggerThan** | a >= b
- **isEqualOrSmallerThan** | a <= b
- **isInRange** | a <= c && c <= b
- **isNotInRage **| a > c || c < b
- **isNegative** | a < 0
- **isPositive** | a > 0
- **isEven** | a % 2 == 0
- **isOdd** | a % 2 != 0


## Examples

```java
import static io.github.puddingspudding.IntegerPredicates.*;

// isEqualTo
Predicate<Integer> isEqualToOne = isEqualTo(1);
if (isEqualToOne.test(1)) {
    // do something
}

// isNotEqualTo
Predicate<Integer> isNotEqualToOne = isNotEqualTo(2);
if (isNotEqualToOne.test(1)) {
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
