var ACHILLES = (function () {
  var iteration=0;
  var foot;
  var calories=0;
  var meters=0;
  function init(){
    console.log("INITING ACHILLES APP");
    setListeners();
  }

  function setListeners(){
    $('.activity').touchOClick(function(){
      $('.main-view').hide();
      $('#startSesion').show();
      $('#runningInterface').hide();
    });
    $('.startRunning').touchOClick(function(){
      $('.main-view').hide();
      $('#startSesion').hide();
      $('#runningInterface').show();
    });

  }

  function startRunning(){
    setInterval(function(){
      iteration++;
      if(iteration%2==0){
        foot="left";
      }
      else{
        foot="right";
      }
      var sensor1=0;
      var sensor2=1;
      var sensor3=2;
      var sensor4=5;

      $.post( "/achilles/recordData",{foot:foot,sensor1:sensor1,sensor2:sensor2,sensor3:sensor3,sensor4:sensor4,calories:calories,meters:meters}, function( data ) {
        alert(data);
      });
    }, 3000);

  }

  return {
    init:init
  }
})();

jQuery.fn.touchOClick = function(f, stopEvent) {
  var i, l, ttouch = 0,
    stopEventFun = function(e) {
      if(stopEvent) {
        e.preventDefault();
        e.stopPropagation();
        e.cancelBubble = true;
      }
    },
    funClick =  function(e) {
      var nt = new Date().getTime();
      stopEventFun(e);
      if (nt - ttouch > 1000) {
        f.apply(this, [e]);
      }
    },
    funTouch = function(e) {
      ttouch = new Date().getTime();
      stopEventFun(e);
      f.apply(this, [e]);
    };

  if(this.length > 0) {
    for(i= 0, l=this.length;i<l;i++) {
      this.eq(i).bind("click", funClick)
        .bind("touchstart",funTouch);
    }
  } else {
    this.bind("click", funClick)
      .bind("touchstart",funTouch);
  }

  return this;
};
