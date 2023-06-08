{{/* This is a comment - Generate basic labels */}}
{{- define "spring.labels" }}
  generator: helm
  app: {{ .Chart.Name }}
  date: {{ now | htmlDate }}
  version: {{ .Chart.Version }}
{{- end }}


{{- define "cron.command"}}
- /bin/sh
- -c
- echo "hello world"