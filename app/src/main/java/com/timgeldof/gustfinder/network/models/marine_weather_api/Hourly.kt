/* 
Copyright (c) 2019 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Hourly (

	val time : Int,
	val tempC : Int,
	val tempF : Int,
	val windspeedMiles : Int,
	val windspeedKmph : Int,
	val winddirDegree : Int,
	val winddir16Point : String,
	val weatherCode : Int,
	val weatherIconUrl : List<WeatherIconUrl>,
	val weatherDesc : List<WeatherDesc>,
	val precipMM : Double,
	val precipInches : Double,
	val humidity : Int,
	val visibility : Int,
	val visibilityMiles : Int,
	val pressure : Int,
	val pressureInches : Int,
	val cloudcover : Int,
	val heatIndexC : Int,
	val heatIndexF : Int,
	val dewPointC : Int,
	val dewPointF : Int,
	val windChillC : Int,
	val windChillF : Int,
	val windGustMiles : Int,
	val windGustKmph : Int,
	val feelsLikeC : Int,
	val feelsLikeF : Int,
	val sigHeight_m : Double,
	val swellHeight_m : Double,
	val swellHeight_ft : Double,
	val swellDir : Int,
	val swellDir16Point : String,
	val swellPeriod_secs : Double,
	val waterTemp_C : Int,
	val waterTemp_F : Int
)