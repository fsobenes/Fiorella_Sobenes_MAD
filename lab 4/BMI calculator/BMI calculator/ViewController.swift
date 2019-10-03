//
//  ViewController.swift
//  BMI calculator
//
//  Created by Fiorella Sobenes on 10/2/19.
//  Copyright © 2019 Fiorella Sobenes. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var stepperOutlet: UIStepper!
    @IBOutlet weak var kilos: UITextField!
    @IBOutlet weak var height: UITextField!
    @IBOutlet weak var bmiResult: UILabel!
   
    @IBAction func stepperAction(_ sender: UIStepper) {
        if stepperOutlet.value == 1{
            kilos.text = "1"
        }
        else{
            kilos.text = String(format: "%.0f", stepperOutlet.value)
        }
        //checkHeight()
    }
    
    @IBAction func calculateBMI(_ sender: UIButton) {
        if height.text!.isEmpty{
            let alert=UIAlertController(title: "Warning", message: "Your height is needed to determine BMI", preferredStyle: UIAlertController.Style.alert)
            let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.height.text = "1.65"
            })
            alert.addAction(okAction)
            present(alert,animated: true,completion:nil)
        }
        else{
            let Fheight = Float(self.height.text!)!
            let Fweight = Float(self.kilos.text!)!
            let squareHeight = Fheight*Fheight
            let bmi:Float = Fweight/squareHeight
            self.bmiResult.text = "Your BMI is \(String(bmi))"
        }
    }
// i could not figure out how to have the done button make the keyboard dissapear
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    //medium.com/@KaushElsewhere/how-to-dismiss-keyboard-in-a-view-controller-of-ios-3b1bfe973ad1
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        view.endEditing(true)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

