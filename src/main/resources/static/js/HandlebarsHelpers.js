Handlebars.registerHelper('eq', function (val1, val2) {
  return val1 == val2;
});

Handlebars.registerHelper('neq', function (val1, val2) {
  return val1 != val2;
});