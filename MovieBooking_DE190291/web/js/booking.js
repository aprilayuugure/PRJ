function booking(movieId) 
{
    const seatCount = prompt("Enter number of seats:");
    
    if (seatCount && !isNaN(seatCount) && parseInt(seatCount) > 0) 
    {
        document.querySelector(`#bookingForm${movieId} input[name='seatCount']`).value = seatCount;
        document.getElementById(`bookingForm${movieId}`).submit();
        
        alert("You booked ${seatCount} tickets");
    } 
    else 
    {
        alert("Please enter a valid seat count.");
    }
}
