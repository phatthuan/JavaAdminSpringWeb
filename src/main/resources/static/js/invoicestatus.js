
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(invoicestatus, status){
            $('#idEdit').val(invoicestatus.id)
            $('#descriptionEdit').val(invoicestatus.description)
            $('#detailsEdit').val(invoicestatus.details)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(invoicestatus, status){
			$('#idDetails').val(invoicestatus.id)
            $('#descriptionDetails').val(invoicestatus.description)
            $('#detailsDetails').val(invoicestatus.details)
			$('#lastModifiedByDetails').val(invoicestatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(invoicestatus.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	

    $('.deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#delRef').attr('href', href);
		$('#deleteModal').modal();		
	});
});