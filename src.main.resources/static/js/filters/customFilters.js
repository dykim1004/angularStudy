/**
 * filter 에서 변경한 내용은 표시 변환만 되고 실제 scope상 원본 데이터는 수정하지 않는다.
 */
angular.module("customFilters", [])
//
.filter("unique", function() {
	return function(data, propertyName) {
		if (angular.isArray(data) && angular.isString(propertyName)) {
			var results = [];
			var keys = {};
			for (var i = 0; i < data.length; i++) {
				var val = data[i][propertyName];
				if (angular.isUndefined(keys[val])) {
					keys[val] = true;
					results.push(val);
				}
			}
			return results;
		} else {
			return data;
		}

	}
})
// range는 페이지에 해당하는 배열 내 일부 영역 항목을 반환한다.
.filter("range", function ($filter) {
    return function (data, page, size) {
        if (angular.isArray(data) && angular.isNumber(page) && angular.isNumber(size)) {
            var start_index = (page - 1) * size;
            if (data.length < start_index) {
                return [];
            } else {
                return $filter("limitTo")(data.splice(start_index), size);
            }
        } else {
            return data;
        }
    }
})
// 데이터 배열을 모두 보여주는데 필요한 페이지 개수를 계산, 페이지 수만큼 숫자 값이 들어있는 배열을 생성
.filter("pageCount", function () {
    return function (data, size) {
        if (angular.isArray(data)) {
            var result = [];
            for (var i = 0; i < Math.ceil(data.length / size) ; i++) {
                result.push(i);
            }
            return result;
        } else {
            return data;
        }
    }
});