## 7장 : 객체 분해
- 불필요한 정보를 제거하고 현재의 문제 해결에 필요한 핵심만 남기는 작업을 추상화라고 한다.
- 일반적인 방법은 한번에 다뤄야 할 문제의 크기를 줄이는 것이다. 이를 분해라고 한다.
- 모든 프로그래밍의 패러다임은 추상화와 분해의 관점에서 설명할 수 있다.
- 소프트웨어는 데이터를 이용해 정보를 표현하고, 프로시저를 이용해 데이터를 조작한다.

### 1. 프로시저 추상화와 데이터 추상화
1. 프로시저 추상화
- 소프트웨어가 무엇을 해야하는지를 추상화 한다.
- 방법으로는 대표적으로 기능분해(알고리즘 분해)가 있다.

2. 데이터 추상화
- 소프트웨어가 무엇을 알아야하는지를 추상화 한다.
- 데이터를 중심으로 '타입'을 추상화, 데이터를 중심으로 '프로시저'를 추상화 하는 방법이 있다.
   - 추상 데이터 타입 : '타입'을 추상화
   - 객체 지향 : '절차 - 프로시저'를 추상화
    

### 2. 프로시저 추상화와 기능 분해
- 프로시저는 반복적으로 실행되거나 거의 유사하게 실행되는 작업을 하나의 장소에 모아 로직을 재사용하고 중복을 방지할 수 있는 추상화 방법이다.
- 전통적인 기능 분해 방법은 하향식(Top-Down) 접근법을 따른다.
- 큰 기능을 작은 단위로 구체화 시키고 기능을 구현한다. 이 때 기능을 중심으로 필요한 데이터를 결정한다.
- 단점 :
   - 시스템은 하나의 메인함수로 이루어진게 아니다.
   - 기능 추가나 요구사항 변경으로 인해 메인 함수를 계속 변경해야 한다.
   - 비즈니스 로직이 사용자 인터페이스(view)와 강하게 결합한다.
   - 너무 이른 시기에 함수들의 실행 순서를 고정시키기 때문에 유연성과 재사용성이 저하된다.
   - 데이터 형식이 변경될 경우 파급 효과를 예측할 수 없다.
  
### 3. 데이터 추상화와 추상 데이터 타입
- 타입은 변수에 저장할 수 있는 내용물의 종류와 변수에 적용할 수 있는 연산의 가짓수를 의미한다.
- 타입은 저장된 값에 대해 수행할 수 있는 연산의 집합을 결정하기 때문에 행동을 예측할 수 있다. 예를 들어 문자열 타입은 연결 연산으로 두 문자열을 합칠 수 있다는 것을 예측할 수 있다.
- '직원의 급여를 계산한다'라는 하나의 커다란 절차(프로시저 추상화)에 집중하기 보다는, '직원', '급여'라는 추상적인 개념을 머릿속에 떠올린 후,
이를 이용해 '계산'에 필요한 절차를 생각하는데 익숙하다. 
- 예제에서는 하나의 'Employee' 추상 데이터 안에 정규직 / 비정규직을 전달되는 파라미터를 통해 결정하는 메서드를 둠으로써 타입을 숨겼다.
- 추상 데이터 타입은 말 그대로 시스템의 상태를 저장할 데이터를 표현한다. 
- 추상 타입으로 표현된 데이터를 이용해서 기능을 구현하는 핵심 로직은 추상 타입 외부에 존재한다.
- 데이터에 대한 관점을 설계의 표현으로 끌어오긴 하지만, 여전히 데이터와 기능을 분리하는 절차적인 틀에 갇혀있다.
- 그렇다면 클래스는 추상 데이터 타입일까?

### 4. 클래스 vs 추상 데이터 타입
- 클래스와 추상 데이터 타입 모두 외부에서는 객체의 내부 속성에 직접 접근할 수 없으며, 퍼블릭 인터페이스를 통해서만 외부와 의사소통한다.
- 하지만 핵심적인 차이는, 추상 데이터 타입은 상속과 다형성을 지원하지 않는다. 
- 다음과 같이 정리할 수 있다.
   - 추상 데이터 타입 : 타입을 추상화 한 것(구체적인 타입을 드러내지 않음) : 타입 추상화
   - 클래스 : 절차(Procedural)를 추상화 한 것(추상 메서드) : 절차 추상화
 
#### 변경을 기준으로 선택하라
- 항상 객체 지향(클래스 타입 사용)이 옳은건 아니다. 이는 변경과 관련되어 있다.
   - 타입 추가에 대한 변경 압력이 강하면,
       - 객체지향 사용한다. 
       - 추상 클래스 / 인터페이스를 통해 명시적 타입의 추가가 쉽다.
     
   - 오퍼레이션 추가(메서드)에 대한 변경 압력이 강하면,
       - 추상 데이터 타입 사용한다. 
       - 객체 지향은 메서드 추가하기 위해서 상속계층의 모든 클래스를 수정해야 한다.
       - 반면 추상 데이터 타입은 전체 타입에 대한 구현 코드가 하나의 구현체 안에 외부로는 보이지 않게 있기 때문에, 새로운 메서드를 추가하는 작업이 상대적으로 간단하다.
  

#### 중요한건 협력이다.
- 객체 지향의 중요한 것은 역할, 책임, 협력이다. 객체 지향은 기능을 수행하기 위해 객체들이 협력하는 방식에 집중한다.
- 객체를 설계하는 방법은 3장의 책임 주도 설계 흐름을 따른다. 
- 객체가 참여할 협력을 결정하고, 협력에 필요한 책임을 수행하기 위해 어떤 객체가 필요한지에 대해 고민하자.
- 그 책임을 다양한 방식으로 수행해야 할 때만 타입 계층 안에 각 절차를 추상화해라. 
- 타입 계층, 다형성은 협력이라는 문맥 안에서 책임을 수행하는 방법에 관해 고민한 '결과물'이어야 하며, 주객전도되어 이게 목적이 되서는 안된다.
