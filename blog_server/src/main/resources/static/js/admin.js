'use strict'

// 日時フォーマット
Vue.filter('formatDateFilter', function (dateValue, formatString) {
  if (null == dateValue) {
    return ''
  }

  formatString = formatString || 'YYYY-MM-DD HH:mm:ss'

  return moment(dateValue).format(formatString)
})

// 数字チャック
function isNumber(value) {
  let reg = /^[0-9]+.?[0-9]*/

  return reg.test(value)
}