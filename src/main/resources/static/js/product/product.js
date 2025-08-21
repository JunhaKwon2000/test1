/**
 * 
 */
const form = document.querySelector('#frm');
const btn = document.querySelector('.delete');
btn.addEventListener('click', () => {
	const check = window.confirm('정말로 상품을 삭제하시겠습니까?');
	if (check) {
		form.submit();
	}
})