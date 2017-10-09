function dropDown() {
	var myDropdown = document.getElementById("notificationForm:notificationContent");
    if (!myDropdown.classList.contains('show')) {
    	myDropdown.classList.toggle('show');
    }
}

function dropUp() {
	var myDropdown = document.getElementById("notificationForm:notificationContent");
    if (myDropdown.classList.contains('show')) {
    	myDropdown.classList.remove('show');
    }else{
    	notificationUpdate();
    }
}