function toggleChevron(e) {
    $(e.target)
        .prev('.panel-heading')
        .find("i.indicator")
        .toggleClass('glyphicon-chevron-down glyphicon-chevron-up');
}
$('#accordion').on('shown.bs.collapse', toggleChevron);
$('#accordion').on('hidden.bs.collapse', toggleChevron);