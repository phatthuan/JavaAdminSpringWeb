
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(supplier, status){
            $('#idEdit').val(supplier.id);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#ddlStateEdit').val(supplier.stateid);
            $('#addressEdit').val(supplier.address);
            $('#cityEdit').val(supplier.city);
            $('#detailsEdit').val(supplier.details);
            $('#emailEdit').val(supplier.email);
            $('#mobileEdit').val(supplier.mobile);
            $('#nameEdit').val(supplier.name);
            $('#phoneEdit').val(supplier.phone);
            $('#websiteEdit').val(supplier.website);
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(supplier, status){
			$('#idDetails').val(supplier.id);
            $('#ddlCountryDetails').val(supplier.countryid);
            $('#ddlStateDetails').val(supplier.stateid);
            $('#addressDetails').val(supplier.address);
            $('#cityDetails').val(supplier.city);
            $('#detailsDetails').val(supplier.details);
            $('#emailDetails').val(supplier.email);
            $('#mobileDetails').val(supplier.mobile);
            $('#nameDetails').val(supplier.name);
            $('#phoneDetails').val(supplier.phone);
            $('#websiteDetails').val(supplier.website);
			$('#lastModifiedByDetails').val(supplier.lastModifiedBy);
			$('#lastModifiedDateDetails').val(supplier.lastModifiedDate.substr(0,19).replace("T", " "));
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