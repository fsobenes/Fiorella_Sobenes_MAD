//
//  ViewController.swift
//  Pets
//
//  Created by Fiorella Sobenes on 9/24/19.
//  Copyright © 2019 Fiorella Sobenes. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var topImage: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var imageControl: UISegmentedControl!
    @IBOutlet weak var fontSizeLabel: UILabel!
    @IBOutlet weak var capitalSwitch: UISwitch!
    
    func updateImage(){
        if imageControl.selectedSegmentIndex == 0{
            titleLabel.textColor = UIColor.red
            titleLabel.text = "Would you look at this dog?!"
            topImage.image = UIImage(named:"dog")
        }
        else if imageControl.selectedSegmentIndex == 1{
            titleLabel.textColor = UIColor.orange
            titleLabel.text = "Here's a super cute cat!"
            topImage.image = UIImage(named:"cat")
        }
    }
    
    func updateCaps(){
        if capitalSwitch.isOn{
            titleLabel.text = titleLabel.text?.uppercased()
        }
        else{
            titleLabel.text = titleLabel.text?.lowercased()
        }
    }
    
    @IBAction func changeImage(_ sender: UISegmentedControl) {
            updateImage()
            updateCaps()
        }
    
    @IBAction func capsLock(_ sender: UISwitch) {
        updateCaps()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize = sender.value
        fontSizeLabel.text = String(format: "%.0f",fontSize)
        let fontSizeCGFloat = CGFloat (fontSize)
        titleLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
}
    
    

    





