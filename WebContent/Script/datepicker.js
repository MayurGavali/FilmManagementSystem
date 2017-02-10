$(function(){

$("#dateSelection").datepicker({
	
	numberOfMonths:1,
		showWeek:true,
		changeMonth:true,
		changeYear:true,
		showButtonPanel:true,
		minDate: new Date(2008,1 - 1,1),
		maxDate: new Date(2020,12 - 1,31),
		dateFormat:"dd-M-yy"
	});



$("#dateSelection").datepicker("setDate",new Date(2016,8-1,10));



});;