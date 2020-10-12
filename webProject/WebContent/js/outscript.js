/**
 * 
 */

function proc1(){
	
	now = new Date();
	
	n1 = now.toLocaleString();
	n2 = now.toLocaleDateString();
	n3 = now.toTimeString();
	 
	vr1 = document.getElementById('result1');
	vr1.innerHTML = "toLocaleString :  " + n1  + "<br>" ;
	vr1.innerHTML += "toLocaleDateString :  " + n2  + "<br>" ;
	vr1.innerHTML += "toTimeString :  " + n3  + "<br>" ;
	
}