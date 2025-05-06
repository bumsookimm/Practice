document.addEventListener("DOMContentLoaded", function(){
	const modalTriggers = document.querySelectorAll("[data-modal-target]")
	
	
	
	modalTriggers.forEach(trigger => {
		trigger.addEventListener("click", function(e) {
			e.preventDefault();
			const targetSelector = trigger.getAttribute("data-modal-target");
			const modal = document.querySelector(targetSelector);
			if(modal) modal.style.display = "block";
			
		})
		
	})
	
	document.querySelectorAll(".modal .close-btn").forEach(btn => {
		btn.addEventListener("click", function () {
			this.closest(".modal").style.display = "none";
		});
	});
	
	
})