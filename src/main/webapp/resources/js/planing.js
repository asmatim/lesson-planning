$( document ).ready(function() {
    console.log( "ready!" );

    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'timeGridWeek',
        locale: 'fr',
        firstDay: 1
    });
    calendar.render();

    var dateStr1 = '2020-08-22T10:00:00';
    var date1 = new Date(dateStr1);

    var dateStr2 = '2020-08-22T12:00:00'
    var date2 = new Date(dateStr2);

    calendar.addEvent({
        title: 'Science',
        start: date1,
        end: date2
    });
});
