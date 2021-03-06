# これは何か

SERVERLESS Framework を利用し、aws-scala-sbt テンプレートを利用して生成したプロジェクトを用いて CloudFront - Api Gateway - Lambda Function と繋がるAPIを構築するサンプルです。

# 使い方

## 事前準備

```
npm install -g serverless
```

## コードの取得

```
git clone https://github.com/ma2saka/serverless-scala-api-sample
cd serverless-scala-api-sample
```

## プロジェクト名の変更

serverless.yml を編集する

```
vi serverless.yml
```

service の名前を編集して適当な名前に変える。

```
service: serverless-hogehoge
```

## ビルドとデプロイ

ビルドする。`target/` 以下に jar ファイルが出力される。

```
sbt assembly
```

デプロイする。

```
serverless deploy -v
```

成功したら、以下のような出力が得られる。

```
Service Information
service: serverless-hogehoge
stage: dev
region: ap-northeast-1
api keys:
  None
endpoints:
  GET - https://fugafugafuga.execute-api.ap-northeast-1.amazonaws.com/dev/hello/{name}
functions:
  hello: serverless-hogehoge-dev-hello

Stack Outputs
WebAppCloudFrontDistributionOutput: d24hogehogehoge.cloudfront.net
HelloLambdaFunctionQualifiedArn: arn:aws:lambda:ap-northeast-1:your-aws-account-id:function:serverless-hogehoge-dev-hello:1
ServiceEndpoint: https://fugafugafuga.execute-api.ap-northeast-1.amazonaws.com/dev
ServerlessDeploymentBucketName: serverless-hogehoge-dev-serverlessdeploymentbucket-uljjru24333sss
```

ここで、三つのコンポーネントが作成されている。関連するロールなども一緒に作られる。SERVERLESS Framrwork は CloudFormationを利用しているのでレシピは流用可能。

- Lambda Function
- Api Gateway
- CloudFront

```
$ curl (クラウドフロントのドメイン)/dev/hello/world
Hello World!
```

## 使い終わったら消す

```
serverless remove
```

S3のバケットが消せなくて失敗するケースがあるので、あとからマネジメントコンソールで CloudFormation のリストを確認すること。

## TODO

- Api GatewayのRestrict化
- 静的ファイルホスティング用のS3バケットの作成と CloudFront のオリジン追加
- java.util.Map を隠す
