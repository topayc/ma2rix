
/*
 * Ma2rix root package
*/

var Ma2rix = function(){};
// Connection package 
Ma2rix.Connection = function(){};
Ma2rix.Connection.prototype = {
		
	get : function(url, data, callback, dataType){
		
	},
	
	post : function(url, data, callback, dataType){
		
	},
	
	load :function(url, selector){
		
	}
};

// Event Package 
Ma2rix.Event = function(){};
Ma2rix.Event.prototype = {
		
	beginScroll : function(target, scrollarrage, callback){
	},
	
	stopScrol : function(){
	}
};

// Instance and Function call
var con = new Ma2rix.Connection();
var event = new Ma2rix.Event();
