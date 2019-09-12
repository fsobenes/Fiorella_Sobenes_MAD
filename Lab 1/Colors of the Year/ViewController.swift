//
//  ViewController.swift
//  Colors of the Year
//
//  Created by Fiorella Sobenes on 9/11/19.
//  Copyright © 2019 Fiorella Sobenes. All rights reserved.
//www.pantone.com/color-intelligence/color-of-the-year/color-of-the-year-2019 -> for all three storyboard images
//www.pinterest.com/pin/537969117968242425/?lp=true -> for loading screen

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var colorText: UITextField!
    
    @IBOutlet weak var colorImage: UIImageView!
    
    @IBAction func buttonYear(_ sender: UIButton) {
    
        if sender.tag==1{
            colorImage.image=UIImage(named:"green")
            colorText.text = "Greenery is symbolic of new beginnings"
        }
        if sender.tag==2{
            colorImage.image = UIImage(named:"violet")
            colorText.text = "Ultra Violet communicates originality"
            
        }
        if sender.tag==3{
            colorImage.image = UIImage(named:"coral")
           colorText.text = "Living Coral embraces us with warmth"
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
}

