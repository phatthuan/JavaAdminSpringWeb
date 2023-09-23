
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(location, status){
            $('#idEdit').val(location.id)
            $('#addressEdit').val(location.address)
            $('#cityEdit').val(location.city)
            $('#ddlCountryEdit').val(location.countryid)
            $('#descriptionEdit').val(location.description)
            $('#detailsEdit').val(location.details)
            $('#ddlStateEdit').val(location.stateid)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(location, status){
			$('#idDetails').val(location.id)
            $('#addressDetails').val(location.address)
            $('#cityDetails').val(location.city)
            $('#ddlCountryDetails').val(location.countryid)
            $('#descriptionDetails').val(location.description)
            $('#detailsDetails').val(location.details)
            $('#ddlStateDetails').val(location.stateid)
			$('#lastModifiedByDetails').val(location.lastModifiedBy);
			$('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", " "));
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