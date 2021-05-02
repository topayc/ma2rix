// GNB 
$(document).ready(function(){  
   $("#gnb ul li").each(function(){  

    var link = $(this).children("a"); 
    var image = $(link).children("img");
    var text = $(link).children("span");
    var imgsrc = $(image).attr("src");  

     // add mouseover
    $(link).mouseover(function(){  
    
     var on = imgsrc.replace("_off","_on");  
     $(image).attr("src",on);  
     text.css("color","#fff");
     });  

    // add mouse out  
     $(link).mouseout(function(){  
      $(image).attr("src",imgsrc);
      text.css("color","#9c9c9d");  
     });
   });
   
  $("form.find .tooltip").click(function(){ 
  	
}); 
   
 });
 
 
	
	