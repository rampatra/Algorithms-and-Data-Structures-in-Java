# Bits

## Basic Operators

#### AND:

| x | y | x `&` y |
----|---|:-------:|
| 0 | 0 | 0       |
| 0 | 1 | 0       |
| 1 | 0 | 0       |
| 1 | 1 | 1       |

#### OR:

| x | y | x `\|` y |
|---|---|:--------:|
| 0 | 0 | 0        |
| 0 | 1 | 1        |
| 1 | 0 | 1        |
| 1 | 1 | 1        |

#### XOR:

| x | y | x `^` y |
|---|---|:-------:|
| 0 | 0 | 0       |
| 0 | 1 | 1       |
| 1 | 0 | 1       |
| 1 | 1 | 0       |


## Shifts

_Disclaimer: We are taking `byte` (8 bits) as our datatype to explain the
 concepts instead of the usual integer._

#### 1. Left Shift (<<):

1 << 3 = 8

> 00000001 << 3 = 00001000

#### 2. Right Shift:

**Two types:**

**a. Signed Right Shift (>>):**

64 >> 2 = 16

> 001000000 >> 2 = 00010000

-64 >> 2 = -16

> 111000000 >> 2 = 11110000 

**b. Unsigned Right Shift (>>>):**

64 >>> 2 = 16

> 001000000 >>> 2 = 00010000

-64 >>> 2 = 56

> 111000000 >>> 2 = 00111000

## Helpful Masks

#### 1. Set the 4th bit from right:

```java
byte mask = 1 << 3;
```

Explanation, 

```
00000001 << 3 = 00001000
```
    
#### 2. Set the first 3 bits from right:

```java
byte mask = (1 << 3) - 1;
```

Explanation,

```
00000001 << 3 = 00001000

00001000 - 00000001 = 00000111
```

#### 3. Mask with alternating 1010...10

```java
byte mask = 0x55;
```

#### 4. Mask with alternating 0101...01

```java
byte mask = 0xaa;
```

#### 5. Unset the 4th bit

```java
byte mask = 1 << 3;

byte num = num & ~mask;
```

Explanation,

```
00000001 << 3 = 00001000

~(00001000) = 11110111
```