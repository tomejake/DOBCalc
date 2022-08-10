### 첫 항목의 레이아웃 margin-top은 주로 8, 16dp 정도 준다.

### res/values/colors.xml에 원하는 색을 미리 만들어놓고 작업하면 효율적이다.

wrap_content / match_parent 차이: https://island-developer.tistory.com/3
- wrap_content: 아이템의 필요한 공간만큼
- match_parent: 부모와 똑같이

### ConstraintLayout: https://developer.android.com/training/constraint-layout?hl=ko
- 드래그 앤 드랍 방식으로 쉽게 개발가능
- relativeLayout 방식 사용시는 XML을 활용하는게 더 편하다.

### 안드로이드 layout 관련 정보: https://velog.io/@ryalya/Android-Layout-%EC%A2%85%EB%A5%98-%EC%82%AC%EC%9A%A9%EB%B2%95

### wrap_content: 부분에는 주로 사이즈값 입력

### android:gravity: 아이템 정렬 관련

### android:orientation: 화면을 가로 또는 세로로 고정시킴


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### 버튼의 배경색 변경은 backgroundTint를 사용한다.

### MainActivity에서 id값으로 아이템 찾는 예시
- val btnDatePicker: Button = findViewById(R.id.btnDatePicker)

## 현재날짜 구해오는 예시
    val myCalendar = Calendar.getInstance()
    val year = myCalendar.get(Calendar.YEAR)
    val month = myCalendar.get(Calendar.MONTH)
    val day = myCalendar.get(Calendar.DAY_OF_MONTH)

## DatePickerDialog
- 날짜를 누를수있는 기능