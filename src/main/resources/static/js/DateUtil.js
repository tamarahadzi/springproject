/**
 * Date Util class
 * @constructor
 */
function DateUtil() {

    /**
     * Substring char
     * @type {string}
     */
    var substringCharDateTime = "T";

    /**
     * Get only Date from DateTime string
     * @param dateTimeString (2018-12-17 || 2018-12-17T00:00...)
     * @returns {string}
     */
    this.getOnlyDate = function (dateTimeString) {
        try {
            if (dateTimeString.trim() !== '') {
                if (dateTimeString.indexOf(substringCharDateTime) !== -1) {
                    return dateTimeString.substr(0,dateTimeString.indexOf(substringCharDateTime));
                } else {
                    return dateTimeString;
                }
            }
        } catch(exception) {
            console.error("getOnlyDate", exception);
        }
        return "0000-00-00";
    };

    /**
     * Get parsed Date ([yyyy,MM,dd])
     * @param date
     * @returns {*}
     */
    this.getParsedDate = function(date) {
        try {
            if (date.trim() !== '') {
                return date.split("-");
            }
        } catch(exception) {
            console.error("getParsedDate",exception);
        }
        return [];
    };

    /**
     * Get current Date by UTC ([yyyy,MM,dd])
     * @param parsedDate
     * @returns {Date}
     */
    this.getCurrentUTC = function(parsedDate) {
        try {
            if (parsedDate.length === 3) {
                return new Date(Date.UTC(Number((parsedDate[0]-0)),Number((parsedDate[1]-1)),Number((parsedDate[2]-0)),0,0,0,0));
            }
        } catch(exception) {
            console.error("getCurrentUTC",exception.message());
        }
        return new Date();
    };

    /**
     * Get Date as a String
     * @param parsedDate
     * @returns {string}
     */
    this.getDateAsString = function(parsedDate) {
        try {
            if (parsedDate.length === 3) {
                return parsedDate[0] + "-" +
                    (parsedDate[1].toString().length === 1 ? ("0" + parsedDate[1].toString()) : parsedDate[1].toString()) + "-" +
                    (parsedDate[2].toString().length === 1 ? ("0" + parsedDate[2].toString()) : parsedDate[2].toString());
            }
        } catch(exception) {
            console.error("getDateAsString", exception);
        }
        return "0000-00-00";
    };

}