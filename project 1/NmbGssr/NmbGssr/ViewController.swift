//
//  ViewController.swift
//  NmbGssr
//
//  Created by Fiorella Sobenes on 10/8/19.
//  Copyright © 2019 Fiorella Sobenes. All rights reserved.
//


//rounded button stackoverflow.com/questions/38874517/how-to-make-a-simple-rounded-button-in-storyboard

//rounded text field stackoverflow.com/questions/34007920/specify-border-radius-of-uitextfield-in-swift

import UIKit

class ViewController: UIViewController,UITextFieldDelegate {
    @IBOutlet weak var startButton: UIButton!
    @IBOutlet weak var enterNumber: UITextField!
    @IBOutlet weak var hintText: UILabel!
    @IBOutlet weak var correctNumber: UILabel!
    @IBOutlet weak var finalText: UILabel!
    
    var num:Int? = 0
    
    
    func resetData(){
    //stackoverflow.com/questions/24007129/how-does-one-generate-a-random-number-in-apples-swift-language
        num = Int.random(in: 1...50)
        hintText.text=""
        correctNumber.text=""
        finalText.text = ""
    }
    
    @IBAction func checkNumber(_ sender: UIButton) {
    //stackoverflow.com/questions/33704961/how-do-i-convert-a-textfields-string-to-a-double-in-xcode-with-swift
        let number = Int(enterNumber.text!)
        startButton.isHidden = false
        
        if enterNumber.text!.isEmpty{
            let alert=UIAlertController(title: "Warning", message: "Please enter a number", preferredStyle: UIAlertController.Style.alert)
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.enterNumber.text = "1"
            })
            alert.addAction(okAction)
            present(alert,animated: true,completion:nil)
        }
        
       else if (number ?? 0 == num ?? 0){
            hintText.text="Correct"
            finalText.text="The Number was..."
            correctNumber.text="\(num ?? 0)"
            //resetData()
        }
       else if (number ?? 0 > num ?? 0){
            finalText.text = "Guess Again"
            hintText.text = "Lower!"
        }
        else if (number ?? 0 < num ?? 0){
            finalText.text="Guess Again"
            hintText.text = "Higher!"
        }
    }
    
    @IBAction func restartButton(_ sender: UIButton) {
        resetData()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        view.endEditing(true)
    }
    
    override func viewDidLoad() {
        startButton.isHidden=true
        resetData()
        enterNumber.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

