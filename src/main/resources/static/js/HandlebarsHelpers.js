Handlebars.registerHelper('eq', function (val1, val2) {
  console.log(val1)
  console.log(val1 == val2)
  return val1 == val2;
});