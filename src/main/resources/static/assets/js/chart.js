$( document ).ready(function() {
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);
  google.charts.setOnLoadCallback(drawChart2);

  $('#kcal').touchOClick(function(){
    $('#curve_kcal').show();
    $('#curve_chart').hide();
  });
  $('#km').touchOClick(function(){
    $('#curve_kcal').hide();
    $('#curve_chart').show();
  });
  function drawChart(){
     var data = google.visualization.arrayToDataTable([
       ['Sesion', 'KMs',],
       ['Season 1',  3],
       ['Season 2',  4],
       ['Season 3',  6],
       ['Season 4',  15]
     ]);

     var options = {
       title: 'KM PER SEASON',
       curveType: 'function',
       legend: { position: 'bottom' }
     };

     var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

     chart.draw(data, options);
  }

   function drawChart2() {
     var data = google.visualization.arrayToDataTable([
       ['Sesion', 'KCAL'],
       ['Season 1',  325],
       ['Season 2',  477],
       ['Season 3', 700],
       ['Season 4',  957]
     ]);

     var options = {
       title: 'KCAL PER SEASON',
       curveType: 'function',
       legend: { position: 'bottom' }
     };

     var chart = new google.visualization.LineChart(document.getElementById('curve_kcal'));

     chart.draw(data, options);
   }

});
