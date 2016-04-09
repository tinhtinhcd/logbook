cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/cordova-plugin-whitelist/whitelist.js",
        "id": "cordova-plugin-whitelist.whitelist",
        "runs": true
    },
    {
        "file": "plugins/cordova-plugin-calendar/www/Calendar.js",
        "id": "cordova-plugin-calendar.Calendar",
        "clobbers": [
            "Calendar"
        ]
    },
    {
        "file": "plugins/cordova-plugin-calendar/test/tests.js",
        "id": "cordova-plugin-calendar.tests"
    },
    {
        "file": "plugins/org.apache.cordova.plugin.datepicker/www/datepicker.js",
        "id": "org.apache.cordova.plugin.datepicker.Datepicker",
        "clobbers": [
            "window.plugins.datePicker"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-whitelist": "1.2.1",
    "cordova-plugin-calendar": "4.4.7",
    "org.apache.cordova.plugin.datepicker": "1.0.0"
};
// BOTTOM OF METADATA
});