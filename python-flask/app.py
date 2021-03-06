import numpy as np
import pandas as pd
from flask import Flask, request, render_template

import pickle

app = Flask(__name__)
model = pickle.load(open('model.pkl', 'rb'))

@app.route('/')
def home():
    
    return render_template('h.html')
@app.route('/detect')
def detect():
    return render_template('index.html')
@app.route('/riskpred')
def riskpred():
    return render_template('r.html')



@app.route('/predict',methods=['POST'])
def predict():
    meantexture=request.json['meantexture']
    meanperimeter=request.json['meanperimeter']
    meansmoothness=request.json['meansmoothness']
    meancompactness=request.json['meancompactness']
    meanconcavity=request.json['meanconcavity']
    meanconcavepoints=request.json['meanconcavepoints']
    meansymmetry=request.json['meansymmetry']
    meanfractaldimension=request.json['meanfractaldimension']
    radiuserror=request.json['radiuserror']
    textureerror=request.json['textureerror']
    perimetererror=request.json['perimetererror']
    areaerror=request.json['areaerror']
    smoothnesserror=request.json['smoothnesserror']
    compactnesserror=request.json['compactnesserror']
    concavityerror=request.json['concavityerror']
    concavepointserror=request.json['concavepointserror']
    symmetryerror=request.json['symmetryerror']
    fractaldimensionerror=request.json['fractaldimensionerror']
    worstradius=request.json['worstradius']
    worsttexture=request.json['worsttexture']
    worstsmoothness=request.json['worstsmoothness']
    worstcompactness=request.json['worstcompactness']
    worstconcavity=request.json['worstconcavity']
    worstconcavepoints=request.json['worstconcavepoints']
    worstsymmetry=request.json['worstsymmetry']
    worstfractaldimension=request.json['worstfractaldimension']
    
    datavalues = [[meantexture,meanperimeter,meansmoothness,meancompactness,meanconcavity,
       meanconcavepoints,meansymmetry,meanfractaldimension,
       radiuserror,textureerror,perimetererror,areaerror,
       smoothnesserror,compactnesserror,concavityerror,
       concavepointserror,symmetryerror,fractaldimensionerror,
       worstradius,worsttexture,worstsmoothness,worstcompactness,worstconcavity,
       worstconcavepoints,worstsymmetry,worstfractaldimension ]]
	   
	   
    data=pd.DataFrame(datavalues,columns=['meantexture','meanperimeter','meansmoothness', 'meancompactness', 'meanconcavity','meanconcavepoints', 'meansymmetry', 'meanfractaldimension','radiuserror', 'textureerror', 'perimetererror', 'areaerror','smoothnesserror', 'compactnesserror', 'concavityerror','concavepointserror', 'symmetryerror', 'fractaldimensionerror','worstradius', 'worsttexture','worstsmoothness', 'worstcompactness', 'worstconcavity','worstconcavepoints', 'worstsymmetry', 'worstfractaldimension'])
    
        
    res=model.predict(data)
    output=res[0]
    
    if output == 0:
        res_val = " breast cancer "
    else:
        res_val = "no breast cancer"
        

    return res_val

if __name__ == "__main__":
    app.run(debug=True)
    