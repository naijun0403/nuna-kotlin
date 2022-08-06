# nuna-kotlin
코틀린에서 사용가능한 누나언어 비공식 컴파일러 입니다.

## 구현
`nuna-kotlin`은 누나언어 0.4를 구현하였습니다

### 구현목표
0.3, 0.2 여러 누나 언어의 버전을 선택가능하게 만들고 싶습니다.

## Q & A
### 어떤식으로 `💕`를 토크나이저가 인식할 수 있습니까?
> 아시다 싶이 `💕`는 유니코드 상으로 2가지 글자로 이루어져있습니다.
> 
> `nuna-kotlin`은 `script`를 `charArray`로 변경하여 한글자씩 분석을 하므로 이 형태는 옳지 않습니다.
> 
> 따라서 인식하기 쉽게 `charArray`로 변경전 `💕`를 `♥`로 변경한뒤 처리를 시작합니다.

### 어떤 누나언어의 표준 버전을 따랏습니까?
> `nuna-kotlin`은 누나언어 0.4를 최대한 따를려고 노력하고 있습니다.
> 
> 표준과 다른부분이 있다면 이슈나 PR을 넣어주세요

### 정수 범위는 어떻게 됩니까?
> `nuna-kotlin`은 기본적으로 `kotlin`의 `Int`형을 기본으로 삼습니다.
> 
> 이후 추가 업데이트로 `Long`을 넣을수도 있으나, 기본적으로 `Int`형의 범위가 같습니다.

### `!` 키워드는 어떤방식으로 출력합니까?
> 코틀린에는 `Int` 클래스에 `toChar`이라는 메소드가 있습니다.
> 
> 해당 메소드를 이용하여 `stack`에서 `pop` 한 정수를 바꿔서 `stringBuilder`에 `append`합니다.
> 
> 이후 리턴할때 `stringBuilder`를 `toString`해 리턴합니다.

## example
```kotlin
import org.nuna.NunaContext

fun main(args: Array<String>) {
    val context = NunaContext.create()

    val res = context.exec('누..')

    println(res.stack)
}
```