/**
 * 
 */

let sliderIndex = 0;
let slides = document.querySelectorAll(".slide");

function showSlides() {
	
	slides.forEach(slide => slide.style.display = "none");
	
	sliderIndex++;
	if (sliderIndex > slides.length) { sliderIndex = 1}
	
	slides[sliderIndex -1].style.display ="block";
	
	setTimeout(showSlides, 3000);
}

showSlides();