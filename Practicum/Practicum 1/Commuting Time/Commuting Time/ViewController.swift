//
//  ViewController.swift
//  Commuting Time
//
//  Created by Fiorella Sobenes on 10/15/19.
//  Copyright © 2019 Fiorella Sobenes. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate{
    
    @IBOutlet weak var commuteSwitch: UISwitch!
    @IBOutlet weak var milesText: UITextField!
    @IBOutlet weak var gasLabel: UILabel!
    @IBOutlet weak var gasSlider: UISlider!
    @IBOutlet weak var transportation: UISegmentedControl!
    @IBOutlet weak var commuteButton: UIButton!
    @IBOutlet weak var totalTime: UILabel!
    @IBOutlet weak var totalGas: UILabel!
    @IBOutlet weak var itemImage: UIImageView!
    
    
    
    
    @IBAction func commuteFunction(_ sender: UIButton) {
        let miles = Float(milesText.text!) ?? 10
        
        if milesText.text!.isEmpty{
            let alert=UIAlertController(title: "Warning", message: "Please enter a number", preferredStyle: UIAlertController.Style.alert)
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.milesText.text = "10"
            })
            alert.addAction(okAction)
            present(alert,animated: true,completion:nil)
        }
        else if transportation.selectedSegmentIndex == 0{
            var timetogo:Float? = (miles / 20) * 60
            if commuteSwitch.isOn{
                timetogo = timetogo! * 20
                totalTime.text = "\(timetogo ?? 10) minutes"
            }
            else{
                totalTime.text = "\(timetogo ?? 10) minutes"
            }
            itemImage.image = UIImage(named:"car")
            totalGas.isHidden = false

        }
        else if transportation.selectedSegmentIndex == 1{
            var timetogo:Float? = (miles / 10) * 60
            if commuteSwitch.isOn{
                 timetogo = timetogo! * 20
                 totalTime.text = "\(timetogo ?? 10) minutes"
            }
            else{
                 totalTime.text = "\(timetogo ?? 10) minutes"
            }
            itemImage.image = UIImage(named:"bike")
            totalGas.isHidden = true
        }
        else if transportation.selectedSegmentIndex == 2{
            var timetogo:Float? = (miles / 12 + 5) * 60
            if commuteSwitch.isOn{
                timetogo = timetogo! * 20
                totalTime.text = "\(timetogo ?? 10) minutes"
            }
            else{
                totalTime.text = "\(timetogo ?? 10) minutes"
            }
            itemImage.image = UIImage(named:"bus")
            totalGas.isHidden = true
        }
    }
    
    @IBAction func gasFunc(_ sender: UISlider) {
        let gallons = sender.value
        gasLabel.text = String(format: "%.2f",gallons)
        var finalGas:Float = gallons / 24
        if commuteSwitch.isOn{
            finalGas = finalGas * 20
            totalGas.text = String(format: "%.2f", finalGas) + " gallons"
        }
        else{
        totalGas.text = String(format: "%.2f", finalGas) + " gallons"
        }
    }
    
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        view.endEditing(true)
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    override func viewDidLoad() {
        milesText.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

