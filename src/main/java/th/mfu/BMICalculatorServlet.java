package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        double bmi = Math.round(calculateBMI(weight,height));

        //TODO: determine the built from BMI
        String built = determinebmi(bmi); 

        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi);
        request.setAttribute("built", built);

        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
    }
    //Calculate BMI
    private double calculateBMI(double weight, double height) {
        // BMI Formula: BMI = weight (kg) / (height (m) * height (m))
        return weight / (height * height);
    }

    // Determine the build from BMI
    private String determinebmi(double bmi) {
        if (bmi < 18.5) {
            return "underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "overweight";
        } else if (bmi >= 30 && bmi < 35) {
            return "obese";
        } else {
            return "extreamly Obese";
        }
    }
}
