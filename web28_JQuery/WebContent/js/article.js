$(function () {
    	//alert($('p').length);
    	
    	var secondP =$('p:eq(1)');
    	//alert(secondP.html());//text()는 가능 val()는 폼값이라서 ㄴㄴ
    	$('a.more').click(function() {
    		if(secondP.is(':hidden')){
    			secondP.slideToggle('slow');
    			$(this).html('read less');
    		}else{
    		secondP.slideToggle('slow');
    			$(this).html('read more');
    		}
		});//clisck
		
		var speech = $('div.speach');
		var defaultsize = speech.css('fontSize');
		
		var num = parseInt(defaultsize,10);
		//alert(num);
		$('#switcher>button').click(function() {
			switch(this.id) {
			case 'sw-l' : num+=5; break;
			case 'sw-s' : num-=5; break;
			default:
			num = parseInt(defaultsize,10);
			}    
			speech.animate({fontSize: num+'px'},'slow');
		});
		
		
	});
