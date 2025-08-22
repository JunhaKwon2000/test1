/**
 * 
 */
const birthYearEl = document.querySelector('#birth-year')
const birthMonthEl = document.querySelector('#birth-month')
const birthDayEl = document.querySelector('#birth-day')
// option 목록 생성 여부 확인
let isYearOptionExisted = false;
let isMonthOptionExisted = false;
let isDayOptionExisted = false;


//윤년 여부 확인 함수
function isLeapYear(year){
	return (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
}

// 월별 최대 일수 반환 함수
function getLastDayOfMonth(year, month){
	if(month === 2){
		return isLeapYear(year) ? 29 : 28;
	}
	// 4,6,9,11 -> 30일, 나머지 31일
	return[4, 6, 9, 11].includes(month) ? 30 : 31;
}



birthYearEl.addEventListener('focus', function () {
  // year 목록 생성되지 않았을 때 (최초 클릭 시)
  if(!isYearOptionExisted) {
    isYearOptionExisted = true;
	const currentYear = new Date().getFullYear();
    for(var i = currentYear; i >= 1920; i--) {
      const YearOption = document.createElement('option')
      YearOption.value = i;
      YearOption.innerText = i;
      this.appendChild(YearOption);
    }
  }
});

// 월 옵션 (1~12)
birthMonthEl.addEventListener('focus',function(){
	if(!isMonthOptionExisted) {
	    isMonthOptionExisted = true;
	for(let i = 1; i<= 12; i++){
		const MonthOption = document.createElement('option')
		MonthOption.value = i;
		MonthOption.innerText = i;
		this.appendChild(MonthOption);	
	}
	}
});

function updateDays(){
	// 기존 일 옵션 제거
	birthDayEl.innerHTML = '<option disabled selected>일</option>';
	
	const year = parseInt(birthYearEl.value);
	const month = parseInt(birthMonthEl.value);
	
	if(!year || !month) return; // 연도/월 미 선택 시 패스
	
	const lastDay = getLastDayOfMonth(year, month);
	for(let d = 1; d <= lastDay; d++){
		const DayOption = document.createElement('option');
		DayOption.value = d;
		DayOption.innerText = d;
		birthDayEl.appendChild(DayOption);
	}
}


// 연도, 월 선택 시 일 갱신
birthYearEl.addEventListener('change', updateDays);
birthMonthEl.addEventListener('change', updateDays);

//최초 클릭 시 기본 31일 세팅
birthDayEl.addEventListener('focus',function(){
	if(!isDayOptionExisted) {
	    isDayOptionExisted = true
		updateDays();
	}
});
