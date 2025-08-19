/**
 * 
 */
const birthYearEl = document.querySelector('#birth-year')
const birthMonthEl = document.querySelector('#birth-month')
const birthDayEl = document.querySelector('#birth-day')
// option 목록 생성 여부 확인
isYearOptionExisted = false;
isMonthOptionExisted = false;
isDayOptionExisted = false;
birthYearEl.addEventListener('focus', function () {
  // year 목록 생성되지 않았을 때 (최초 클릭 시)
  if(!isYearOptionExisted) {
    isYearOptionExisted = true
    for(var i = 1940; i <= 2022; i++) {
      // option element 생성
      const YearOption = document.createElement('option')
      YearOption.setAttribute('value', i)
      YearOption.innerText = i
      // birthYearEl의 자식 요소로 추가
      this.appendChild(YearOption);
    }
  }
});

birthMonthEl.addEventListener('focus',function(){
	if(!isMonthOptionExisted) {
	    isMonthOptionExisted = true
	for(var i = 1; i<= 12; i++){
		const MonthOption = document.createElement('option')
		MonthOption.setAttribute('value', i)
		MonthOption.innerText = i
		this.appendChild(MonthOption);	
	}
	}
});

birthDayEl.addEventListener('focus',function(){
	if(!isDayOptionExisted) {
	    isDayOptionExisted = true
	for(var i = 1; i<= 31; i++){
		const DayOption = document.createElement('option')
		DayOption.setAttribute('value', i)
		DayOption.innerText = i
		this.appendChild(DayOption);	
	}
	}
});
