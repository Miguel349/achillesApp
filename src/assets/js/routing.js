$( document ).ready(function() {
    console.log( "ready!" );

    document.getElementById('stats-option').addEventListener("click", userOption);
});


function userOption(event){
   var x = event.target.id;
   if (x == "stats-option") {
     console.log("stats")
  $('.main-view').fadeOut()
  .css({
    "display":"none"
  })

  $('.stats-view').fadeOut()
  .css({
    "display":"block"

  })
}
}
