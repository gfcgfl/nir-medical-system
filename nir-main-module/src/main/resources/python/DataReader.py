# coding:utf-8
"""
Name : Painter.py
Author : the_best_wj
Time : 2019/12/11
"""


class DataReader:

    # def __init__(self, file_path):
    #     self.data = pd.read_csv(file_path, sep=' ', index_col=False,nrows=5,skiprows=5)

    def __init__(self, data):
        self.data = data

    def des(self):
        print(self.data.describe())
        print(self.data.head())
        print(self.data.columns)

    def get(self, col):
        return self.data[col].to_numpy()

    def max(self, col):
        return self.data[col].max()

    def min(self, col):
        return self.data[col].min()

    def count(self, col):
        return self.data[col].count()
