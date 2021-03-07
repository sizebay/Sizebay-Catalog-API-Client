resource "aws_codeartifact_repository" "maven_sizebay_repository_sizebay_catalog_api_client" {
  repository = var.repository
  domain     = var.domain
  tags = {
    "CodeArtifact" = "repository:maven:${var.repository}"
  }
}