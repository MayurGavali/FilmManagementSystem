
//Title Validation

function istitlevalidate()  
{   
		var filmtitle=filmf.filmtitle.value;
		
		var letters = /^[A-Za-z]+$/;  
		if(filmtitle.match(letters))  
		{  
			document.getElementById("titleerr").innerHTML="";
			return true;  
		}  
		else  
		{  
			document.getElementById("titleerr").innerHTML="*Title should only contain alphabet"; 
			filmtitle.focus();  
			return false;  
		}  
}  



//Description Validation
function isdescriptionvalidate()  
{   
		var filmdescription=filmf.filmdescription.value;
		
		var letters = /^[A-Za-z]+$/;  
		if(filmdescription.match(letters))  
		{  
			document.getElementById("descerr").innerHTML="";
			return true;  
		}  
		else  
		{  
			document.getElementById("descerr").innerHTML="*Description should only contain alphabet"; 
			filmdescription.focus();  
			return false;  
		}  
}  



//Length Validation
function islengthvalid(){
	
	var filmlength=filmf.filmlength.value;

    //if(isNaN(filmlength)||filmlength>1 || filmlength<1000){
    	
    	 if(isNaN(filmlength)&& filmlength>=1 && filmlength<=1000){
    	
    	
    	document.getElementById("lenghterr").innerHTML="";
		return true;  
    }
    else
    {
    	document.getElementById("lenghterr").innerHTML="*Length should a number be between 1 to 1000"; 
    	filmlength.focus();  
		return false; 
    }
    
	
}


//ReleaseDate And RentalDuration (Rental>Release)

function isrentaldurationvalid(){
	
	var ReleaseDate=addfilm.releasedate.value;
	var RentalDuration=filmf.rentalduration.value;


    	
    	 if(RentalDuration>ReleaseDate){
    	
    	
    	document.getElementById("rentaldurationerr").innerHTML="";
		return true;  
    }
    else
    {
    	document.getElementById("rentaldurationerr").innerHTML="*RentalDate shhould be Greater than ReleaseDate"; 
    	rentalduration.focus();  
		return false; 
    }
    

//Rating Validation
function isratingSelected()  
{  
	var Rating=filmf.rating.value;
if(Rating.value != "Default")  
{  
	  
	document.getElementById("rating").innerHTML="";
	return true; 
}  
else  
{  
	document.getElementById("rating").innerHTML="*Please Select any one Rating"; 
	rating.focus();  
	return false; 
	
}

//Replacement Cost Validation 
function isreplacementcostvalid(){
	
	var replacementcost=filmf.replacementcost.value;

  	
  	 if(isNaN(replacementcost)&& replacementcost>=1 && replacementcost<=1000){
  		
  	
  	document.getElementById("replacementcosterr").innerHTML="";
		return false ;  
  }
  else
  {
  	document.getElementById("replacementcosterr").innerHTML="*Replacement Cost should a number be between 1 to 10000"; 
  	replacementcost.focus();  
		return true; 
  }
  
	
}

	

}
}


