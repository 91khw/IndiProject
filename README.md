# IndiProject<h1>Train(학습)</h1>

![train1.train,valid_num 학습개수에 맞게 수정하여 학습실행](C:\Users\User\Desktop\자바수업\프로젝트\그룹 프로젝트\kospeech 코드변경사항\train1.train,valid_num 학습개수에 맞게 수정하여 학습실행.PNG)

train, valid_num 학습개수에 맞게 수정하여 학습실행



<strong>실행문</strong>

python ./bin/main.py model=las train=las_train train.dataset_path=C:\Users\User\Speech\KoSpeech



<h1>Inference(추론)

모델.pt 경로지정, C:\Users\User\Speech\KoSpeech\data\vocab에 aihub_character_vocabs이동

![inference1. inference.py 파일에서 require을 required로 변경](C:\Users\User\Desktop\자바수업\프로젝트\그룹 프로젝트\kospeech 코드변경사항\inference1. inference.py 파일에서 require을 required로 변경.PNG)

require >> required

![inference2. greedy search를 recognize로 변경후 opt.device 코드 삭제](C:\Users\User\Desktop\자바수업\프로젝트\그룹 프로젝트\kospeech 코드변경사항\inference2. greedy search를 recognize로 변경후 opt.device 코드 삭제.PNG)

greedy search를 recognize로 변경후 opt.device 코드 삭제



<strong>실행문</strong>

python ./bin/inference.py --model_path='C:/Users/User/Speech/KoSpeech/model.pt' --audio_path='C:/Users/User/Speech/KoSpeech/KsponSpeech_01/KsponSpeech_0001/KsponSpeech_000984.pcm'  --device='cpu'



<h1>wav2pcm 코드</h1>

import wave
import librosa
import soundfile as sf

def sampling(input_wav, output_pcm, resample_sr=16000):
    wav = wave.open(input_wav, "rb")
    y, sr = librosa.load(input_wav, sr=wav.getframerate())
    resample = librosa.resample(y, sr, resample_sr)
    sf.write(output_pcm, resample, 16000, format='WAV', endian='LITTLE',subtype='PCM_16')
    
sampling("C:/Users/User/Speech/KoSpeech/KsponSpeech_01/Record_Files/heLoveHisWife.wav", "C:/Users/User/Speech/KoSpeech/KsponSpeech_01/Record_Files/test.pcm", 16000)
