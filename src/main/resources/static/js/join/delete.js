/**
 * 
 */
const form = document.querySelector('#frm');
const btn = document.querySelector('.delete');
btn.addEventListener('click', () => {
	const check = window.confirm('회원탈퇴 하시겠습니까?');
	if (check) {
		form.submit();
	}
})