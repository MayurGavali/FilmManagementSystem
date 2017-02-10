$(function(){

	$("#datepicker").datepicker({
		
		numberOfMonths:1,
			showWeek:false,
			changeMonth:true,
			changeYear:true,
			showButtonPanel:true,
			maxDate: new Date(),
			dateFormat:"dd-M-yy"
		});
		
		$("#datepicker").datepicker("setDate",new Date());
	});

$(function(){

	$("#datepicker1").datepicker({
		
		numberOfMonths:1,
			showWeek:false,
			changeMonth:true,
			changeYear:true,
			showButtonPanel:true,
			dateFormat:"dd-M-yy"
		});
		
		$("#datepicker1").datepicker("setDate",$("#releaseYear").val());
	});